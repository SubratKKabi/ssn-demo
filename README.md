# Angular ssn DEMO project

The nine-digit SSN is composed of three parts:
The first set of three digits is called the Area Number
The second set of two digits is called the Group Number
The final set of four digits is the Serial Number
SSN must be validated in the backend;

Run `ng serve --port 4200` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

To clone the project from github,Please execute these commands in git bash:-
1. git clone https://github.com/SubratKKabi/ssn-demo.git
2. cd ssn-demo
3. git checkout master (master branch has all the project folders)
4. The folder "angular-14-client" contains the angular frontend project. The folder "spring-boot-server" contains the springboot java backend project.

To execute the "angular-14-client" angular frontend project, please follow the below steps:-
1. Open Visual Studio code. Go to File->open folder-> /ssn-demo/angular-14-client.
2. In VS code->Terminal->New terminal-> npm install to install node package manager.
3. In VS code  terminal , run 'ng server --open'. The angular appliation will run in http://localhost:4200/.

To execute the "spring-boot-server" java backend project, please follow the below steps:-
1. Open Eclipse-> create a new workspace.
2. Go to File -> Import-> Gradle -> Existing Gradle Project -> Project Directory-> path to ...\ssn-demo\spring-boot-server. Click  on Finish.
3. Open a terminal in Git Bash. Go to ...\ssn-demo\spring-boot-server.
4. To build the project -> ./gradlew clean build
5. To run the application -> ./gradlew run.




