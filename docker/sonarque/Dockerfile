FROM sonarqube:latest

ENV SONAR_DOWNLOAD_URL https://repo1.maven.org/maven2/org/sonarsource

# Install curl
RUN apk --no-cache add curl

# Installing Plugins
RUN cd /opt/sonarqube/extensions/plugins/
# RUN curl -o sonar-csharp-plugin.jar -fSL $SONAR_DOWNLOAD_URL/dotnet/sonar-csharp-plugin/8.13.1.21947/sonar-csharp-plugin-8.13.1.21947.jar
# RUN curl -o sonar-css-plugin.jar -fSL $SONAR_DOWNLOAD_URL/css/sonar-css-plugin/1.0.0.457/sonar-css-plugin-1.0.0.457.jar
# RUN curl -o sonar-go-plugin.jar -fSL $SONAR_DOWNLOAD_URL/slang/sonar-go-plugin/1.7.0.883/sonar-go-plugin-1.7.0.883.jar
# RUN curl -o sonar-java-plugin.jar -fSL $SONAR_DOWNLOAD_URL/java/sonar-java-plugin/6.9.0.23563/sonar-java-plugin-6.9.0.23563.jar
# RUN curl -o sonar-javascript-plugin.jar -fSL $SONAR_DOWNLOAD_URL/javascript/sonar-javascript-plugin/6.5.0.13383/sonar-javascript-plugin-6.5.0.13383.jar
# RUN curl -o sonar-kotlin-plugin.jar -fSL $SONAR_DOWNLOAD_URL/slang/sonar-kotlin-plugin/1.7.0.883/sonar-kotlin-plugin-1.7.0.883.jar
# RUN curl -o sonar-php-plugin.jar -fSL $SONAR_DOWNLOAD_URL/php/sonar-php-plugin/3.9.0.6331/sonar-php-plugin-3.9.0.6331.jar
# RUN curl -o sonar-python-plugin.jar -fSL $SONAR_DOWNLOAD_URL/python/sonar-python-plugin/3.1.0.7619/sonar-python-plugin-3.1.0.7619.jar
# RUN curl -o sonar-scm-git-plugin.jar -fSL $SONAR_DOWNLOAD_URL/scm/git/sonar-scm-git-plugin/1.9.1.1834/sonar-scm-git-plugin-1.9.1.1834.jar
# RUN curl -o sonar-typescript-plugin.jar -fSL $SONAR_DOWNLOAD_URL/typescript/sonar-typescript-plugin/2.1.0.4359/sonar-typescript-plugin-2.1.0.4359.jar
# RUN curl -o sonar-vbnet-plugin -fSL $SONAR_DOWNLOAD_URL/dotnet/sonar-vbnet-plugin/8.13.1.21947/sonar-vbnet-plugin-8.13.1.21947.jar
# RUN curl -o sonar-web-plugin.jar -fSL $SONAR_DOWNLOAD_URL/web/sonar-web-plugin/2.6.0.1053/sonar-web-plugin-2.6.0.1053.jar
# RUN curl -o sonar-xml-plugin.jar -fSL $SONAR_DOWNLOAD_URL/xml/sonar-xml-plugin/2.0.1.2020/sonar-xml-plugin-2.0.1.2020.jar

# Add default Java Quality Profile
ADD qualityprofile/java-standardprofile.xml /qualityprofile/

VOLUME ["$SONARQUBE_HOME/data", "$SONARQUBE_HOME/extensions", "/qualityprofile"]

ADD start_with_profile.sh /opt/sonarqube/start_with_profile.sh

ENTRYPOINT ["/opt/sonarqube/start_with_profile.sh"]
