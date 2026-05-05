# JavaFX is not bundled with JDK 11+. This script downloads OpenJFX (Windows)
# into javafx-lib/, compiles the default-package classes, and runs CommandApp.
$ErrorActionPreference = 'Stop'

$jfxVersion = '25.0.2'
$repoBase = 'https://repo1.maven.org/maven2/org/openjfx'
$libDir = Join-Path $PSScriptRoot 'javafx-lib'
$outDir = Join-Path $PSScriptRoot 'out'

$artifacts = @(
    @{ Name = 'javafx-base';    Jar = "javafx-base-$jfxVersion-win.jar" },
    @{ Name = 'javafx-graphics'; Jar = "javafx-graphics-$jfxVersion-win.jar" },
    @{ Name = 'javafx-controls'; Jar = "javafx-controls-$jfxVersion-win.jar" }
)

New-Item -ItemType Directory -Force -Path $libDir, $outDir | Out-Null

foreach ($a in $artifacts) {
    $dest = Join-Path $libDir $a.Jar
    if (-not (Test-Path -LiteralPath $dest)) {
        $url = "$repoBase/$($a.Name)/$jfxVersion/$($a.Jar)"
        Write-Host "Downloading $($a.Jar) ..."
        Invoke-WebRequest -Uri $url -OutFile $dest -UseBasicParsing
    }
}

$modulePath = $libDir
$javacArgs = @(
    '--module-path', $modulePath,
    '--add-modules', 'javafx.controls',
    '-d', $outDir,
    (Join-Path $PSScriptRoot 'Commands.Command.java'),
    (Join-Path $PSScriptRoot 'Logic.PixelGrid.java'),
    (Join-Path $PSScriptRoot 'CommandApp.java')
)

Write-Host 'Compiling...'
& javac @javacArgs

$javaArgs = @(
    '--enable-native-access=javafx.graphics',
    '--module-path', $modulePath,
    '--add-modules', 'javafx.controls',
    '-cp', $outDir,
    'CommandApp'
)

Write-Host 'Starting JavaFX app...'
& java @javaArgs
