set -e
ant clean
ant build
cp ANTLR_LICENSE bin
cp LICENSE bin
cp lib/antlr-runtime-4.7.2.jar bin
cd bin
unzip antlr-runtime-4.7.2.jar
rm -rf META-INF
rm antlr-runtime-4.7.2.jar
jar cvfm MScript.jar ../MScript.mf *
cd ..
mv bin/MScript.jar .