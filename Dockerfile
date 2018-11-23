FROM daggerok/jboss:eap-6.4
ENV JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 "
EXPOSE 5005
ADD ./target/*.war ${JBOSS_HOME}/standalone/deployments/my-chat.war
