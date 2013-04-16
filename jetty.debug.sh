OLD_MAVEN_OPTS=$MAVEN_OPTS

export MAVEN_OPTS="$MAVEN_OPTS -Xmx512M -XX:PermSize=256m -XX:MaxPermSize=512m -Djava.awt.headless=true -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"

mvn clean jetty:run

MAVEN_OPTS=$OLD_MAVEN_OPTS
