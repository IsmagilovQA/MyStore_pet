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

WebHook configuration

Links:
-  https://www.blazemeter.com/blog/how-to-integrate-your-github-repository-to-your-jenkins-project
- https://dashboard.ngrok.com/get-started

* Go to any gitHub repository, open project settings - Webhooks tab
* Linking through localhost:8080 is not possible, so we need to get real server address
* We can use ngrok to simulate real server. Setup server
* Put http://bbf7a340.ngrok.io/github-webhook/ address to the Payload URL with github-webhook/ at the end
* Set content-type as JSON
* Put checkmark ‘Let me select individual events’ and select Pushes, Pull requests and Active -> Create web hook. So this webhhok will ping Jenkins once we have any changes from GitHub repository
* Go to Jenkins -> Start Jenkins from terminal->Open browser on  http://bbf7a340.ngrok.io/ page -> Go to Configure system -> pass http://bbf7a340.ngrok.io/ as Jenkins URL
* Go to job settings -> in the section Build Triggers set ‘GitHub hook trigger for GITScm polling’ - Save

Configure Allure2 reporting:

* Jenkins -> go to Manage plains
* Download Allure plugin
* Reload Jenkins
* Manage Jenkins -> Global Tool Configuration -> Find ‘Allure Commandline’ section
* Set ‘allure2’ as Name
* Put checkmark ‘Install automatically’
* Choose From maven central -> select allure version
* Go to Job settings and in Post build section select Allure report
* Fill in Path as ‘build/allure-results’
* Run the job. Allure report will be generated.

