# MailSendingTest
Automated testing of message sending via Mail.ru. There are a few steps.
Main class "MailSendTest" includes three method that should be tested succsessfully:
setup() method with @BeforeClass annotation. This method creates a driver, opens a browser and navigates to the website specified in the configuration file.
loginTest() method with @Test annotation. This method does all the work that is required to achieve our goal: logs into the website, calls a new message window, 
inserts the addressee and the message body, and then sends it.
closeDown() method with @AfterClass annotation. Log out (not necessary, but I decided to add this function) and closing the browser.
