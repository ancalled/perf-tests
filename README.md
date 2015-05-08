# perf-tests
My sandbox for performance tests


Install this to local maven repo:


git clone https://github.com/real-logic/Aeron/wiki/Java-Programming-Guide \
	&& cd ./Agrona-master \
	&& gradlew clean install \
	&& mvn install:install-file -Dfile=./Agrona-0.3.2-SNAPSHOT.jar -DgroupId=uk.co.real-logic -DartifactId=agrona -Dversion=0.3.2 -Dpackaging=jar

git clone https://github.com/real-logic/simple-binary-encoding \
	&& cd ./simple-binary-encoding-master
	&& gradlew clean install \
	&& mvn install:install-file -Dfile=./sbe-1.0.4-RC2-SNAPSHOT.jar -DgroupId=uk.co.real-logic -DartifactId=sbe -Dversion=1.0.4 -Dpackaging=jar

wget http://ncu.dl.sourceforge.net/project/quickfixj/QuickFIX_J/1.6.0/org.quickfixj-1.6.0-bin.zip

mvn install:install-file -Dfile=./quickfixj-core-1.5.2.jar -DgroupId=quickfixj -DartifactId=quickfixj-core -Dversion=1.5.2 -Dpackaging=jar
mvn install:install-file -Dfile=./quickfixj-msg-fix44-1.5.2.jar -DgroupId=quickfixj -DartifactId=quickfixj-msg-fix44 -Dversion=1.5.2 -Dpackaging=jar

mvn install:install-file -Dfile=./aeron-driver-0.1-SNAPSHOT.jar -DgroupId=uk.co.real-logic -DartifactId=aeron-driver -Dversion=0.1 -Dpackaging=jar
mvn install:install-file -Dfile=./aeron-common-0.1-SNAPSHOT.jar -DgroupId=uk.co.real-logic -DartifactId=aeron-common -Dversion=0.1 -Dpackaging=jar
mvn install:install-file -Dfile=./aeron-client-0.1-SNAPSHOT.jar -DgroupId=uk.co.real-logic -DartifactId=aeron-client -Dversion=0.1 -Dpackaging=jar
mvn install:install-file -Dfile=./disruptor-3.3.2.jar -DgroupId=com.googlecode.disruptor -DartifactId=disruptor -Dversion=3.3.2 -Dpackaging=jar

mvn install:install-file -Dfile=./HdrHistogram-2.1.5-SNAPSHOT.jar -DgroupId=org.HdrHistogram -DartifactId=HdrHistogram -Dversion=2.1.5 -Dpackaging=jar







