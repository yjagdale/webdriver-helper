[![Travis Build Status](https://travis-ci.org/webdriverextensions/webdriverextensions.svg?branch=master)](https://travis-ci.org/webdriverextensions/webdriverextensions) [![Maven Central](https://img.shields.io/maven-central/v/com.github.webdriverextensions/webdriverextensions.svg)](https://search.maven.org/search?q=com.github.yjagdale)

WebDriver Helper
===================

WebDriver Helper Extensions is designed to simplify Java based Selenium/WebDriver tests. It's built on top of Selenium/WebDriver to make your tests more readable, reusabable and maintainable by providing easy handling towards browser and advance identifiers.

Available through the [Maven Central Repository](http://mvnrepository.com/search?q=webdriverextensions)! Latest release is version 3.10.0 which includes selenium-java 3.8.1 as a transitive dependency.


<br>

### What's included in this utility?
- Browser handling ( interaction towards all the available browsers)
- Advanced selenium identifiers which can help you for rapid developement.
- Advanced way to manage driver executables for each env(ubuntu/mac/windows) [Webdrivermanager](https://github.com/bonigarcia/webdrivermanager)
- Muti browser support.
<br>

### Want to Contribute?
If you find a bug or have a feature request please [create a new GitHub issue](https://github.com/webdriverextensions/webdriverextensions/issues/new) or even better clone this repository, commit your changes and make a [Pull Request](https://help.github.com/articles/using-pull-requests/).

<br>

### Have any Questions?
If you have question you can [ask them in a GitHub issue](https://github.com/yjagdale/webdriver-helper/issues/new).

<br>

# Content
- [Hello World Example](#hello-world-example)
    - [With WebDriver Extensions](#with-webdriver-extensions)
- [License](#license)



<br>

# Hello World Example
Here is an example of how a cross browser test looks like with and without the WebDriver Extensions Framework. The test will run on Firefox, Chrome and Internet Explorer. It will google for "Hello World" and assert that the search result contains the searched text "Hello World".

<a href="https://github.com/yjagdale/webdriver-helper-impl"> Sample Project </a>


### config file 

```properties
browser=chrome
implicit_wait=20
default_wait=30
base_url=https://opensource-demo.orangehrmlive.com/
```



### With WebDriver Extensions
```java
 @Test
    public void validationMessagePassword() {
        ElementActions.sendKeys("User Name", "Admin");
        ElementActions.click("Login");
        String errorMessage = ElementActions.getText("Error Message");
        Assert.assertEquals(errorMessage, "Password cannot be empty");
    }


    @Test
    public void validationMessageUser() {
        ElementActions.clear("User Name");
        ElementActions.sendKeys("Password", "admin123");
        ElementActions.click("Login");
        String errorMessage = ElementActions.getText("Error Message");
        Assert.assertEquals(errorMessage, "Username cannot be empty");
    }
```
_<sub>Imports are hidden for the sake of simplicity, for imports and instructions on how to run this example see this [gist](https://gist.github.com/andidev/ad006a454edfd9f0e9e5)</sub>_


<br>


### Debug Mode

```java
 System.setProperty("DEBUG_MODE", "true");
```

Once you enable debug mode every action will be displayed with toast message as well as element will be highlighted.
<a href="http://52.183.43.60/dashboard/#"> Demo Video </a> Can be seen here.


# License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
