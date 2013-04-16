OLD_MAVEN_OPTS=$MAVEN_OPTS

DIR=`pwd`

export MAVEN_OPTS="-Xmx512M -XX:PermSize=256m -XX:MaxPermSize=512m -Djava.awt.headless=true -noverify -javaagent:$JREBEL_HOME/jrebel.jar"
mvn clean jetty:run -Dproject.root=$DIR -Pdev-jrebel

MAVEN_OPTS=$OLD_MAVEN_OPTS