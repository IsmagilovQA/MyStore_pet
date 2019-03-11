Pet automation project: Java + Selenide + JUnit5 + gradle + Allure + Jenkins + Video Recorder + Highlighting while running tests

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

///

WebHook configuration

Links:
-  https://www.blazemeter.com/blog/how-to-integrate-your-github-repository-to-your-jenkins-project
- https://dashboard.ngrok.com/get-started

* Go to any gitHub repository, open project settings - Webhooks tab
* Linking through localhost:8080 is not possible, so we need to get real server address
* We can use ngrok to simulate real server. Download the ngrok on computer. Open terminal and run './ngrok http 8080' from derictory where ngrok was saved. Copy link from terminal, like 'http://41f311c2.ngrok.io'. This link is a temporary tunnel (which expires in 8 hours).
* Put http://bbf7a340.ngrok.io/github-webhook/ address to the Payload URL with github-webhook/ at the end
* Set content-type as JSON
* Put checkmark ‘Let me select individual events’ and select Pushes, Pull requests and Active -> Create web hook. So this webhhok will ping Jenkins once we have any changes from GitHub repository
* Go to Jenkins -> Start Jenkins from terminal->Open browser on  http://bbf7a340.ngrok.io/ page -> Go to Configure system -> pass http://bbf7a340.ngrok.io/ as Jenkins URL
* Go to job settings -> in the section Build Triggers set ‘GitHub hook trigger for GITScm polling’ - Save

///

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

///

 - Video Recorder https://github.com/SergeyPirogov/video-recorder-java
 
 ///
 
 - Highlighting while running tests (services -> Highlighter.class)
 
 ///
 
 Setup Selenoid from scretch
 
 https://www.youtube.com/watch?v=mxHqCMhpnaE&t=7s 
 https://aerokube.com/selenoid/latest/#_quick_start_guide
 
 // Run Selenoid + see live browser screen                  ./cm selenoid start --vnc --force
 // Stop Selenoid                                           ./cm selenoid stop
 
 // Run Selenoid-UI                                         ./cm selenoid-ui start --force
 // Stop Selenoid-ui                                        ./cm selenoid-ui stop
 
 // Open web page for displaying selenoid-UI                 http://localhost:8080
 
 // Status                                                  ./cm selenoid status
 // Help with all commands                                  ./cm selenoid --help
 
 
 // Lists running containers      docker ps -a
 // List of images                docker images
 
 // Stop container with ID        docker stop 'my_container ID'
 // Remove container with ID      docker rm 'my_container ID'
 
 // Help                          docker --help
 
 // check port   lsof -i:4444
 
 /*
 docker stop $(docker ps -a -q);
 docker rm $(docker ps -a -q);
 docker volume rm $(docker volume ls -qf dangling=true)
 docker network rm $(docker network ls -q)
 sudo lsof -nP | grep LISTEN
 sudo kill -9 1548
 */
 
 // STEP INSTRUCTIONS:
 /*
 1. Run docker
 2. Run Selenoid VNC - ./cm selenoid start --vnc --force
 3. Run Selenoid UI  - ./cm selenoid-ui start --force
 4. Open browser  -    http://localhost:8080
 5. Make sure both indicators are green
 6. Add Selenoid conficurations to test (@Before) - see the code below in @BeforeSuite
 7. Run tests
 8. After work:
 9. Display lists with running containers  -  docker ps -a
 10. Stop containers (both Selenoid and Selenoid-ui containres) -  docker stop 'my_container ID'
 11. Remove both containers -  docker rm 'my_container ID'
 12. Make sure no containers any more  -  docker ps -a
 13. Stop Selenoid-ui  -  ./cm selenoid-ui stop
 14. Stop Selenoid -  ./cm selenoid stop
 15. Clean Selenoid configuration -  ./cm selenoid cleanup
 16. Close docker
 */
 
 @BeforeSuite
 public void setup() throws MalformedURLException {
 
 /*
 // Selenoid conficurations
 DesiredCapabilities capabilities = new DesiredCapabilities();
 capabilities.setCapability("enableVideo", false);
 capabilities.setCapability("enableVNC", true);
 Configuration.browserCapabilities = capabilities;
 Configuration.remote = "http://localhost:4444/wd/hub";
 Configuration.browser = "chrome";
 Configuration.browserSize = "1280x1024";
 */
