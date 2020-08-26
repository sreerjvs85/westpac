# westpac kiwisaver pom framework design

1. Pre Requisites:
    Java (jdk and jre) latest version installed and environment path set
    Maven latest version and environment path set
    Chrome browser latest version installed.

2. Development:
    IDE: Intellij
    CI: Jenkins
    Folder structure: Maven
    Framework : Page Object Model + BDD (Cucumber)
    Language: Java, Gherkin
    Tested Platforms: Mac, Windows, Ubuntu
    Supported Browsers: Chrome, Firefox
    
3. Execution:
    Download/Clone the repo into local drive
    cd into your local repo location and cmd/terminal
    check if java home and maven home are set.
    use "mvn clean verify" command to execute the test suite
    chrome driver will be used by default for this solution
    4 scenarios to test kiwi saver functionality has been added to the suite.
   
4. Reports:
    After execution is completed, report's path will be displayed in cmd/terminal "Cluecumber Report: ..."
    Html report.
