Pet automation project: Java + Selenide + JUnit5 + gradle + Allure + Jenkins

Jenkins configurations

* To start Jenkins write In terminal: java -jar jenkins.war (from directory where .war is located);
* Open browser on localhost:8080;
* Create Job (free template);
* Fill in git repository link to Git plugin section;
* Config Gradle section:
- set check mark ‘Use Gradle Wrapper’;
- set mark on ‘Make gradlew executable’;
- set ‘clean test’ or another task like ‘fastTest’ from gradle.build in Task field (to run specific suite/class/tag or something else);
- set Switches' field as  --scan -s  to generate a build scan and render a stack trace in case of a build failure
* Config JUnit reports (**/TEST-*.xml);
* Stop Jenkins: ‘control + c’ in the terminal

Plugins:
- Git (git plugin);
- Gradle (Gradle plugin)
- Test-results-analyzer plugin
- Locale plugin
- GreenBalls plugin

