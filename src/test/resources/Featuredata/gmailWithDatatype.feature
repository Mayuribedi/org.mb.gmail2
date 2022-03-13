Feature: Gmail mail compose

  Scenario: 
    Given open "Chrome" Browser
    When launch site using "http://www.gmail.com"
    When do login using "mayya.rosh1111" and "Apple_123"
    Then compose is displayed
    When click on compose page and fill field and send mail and check response
      | to                   | subject | body      | attachment                     |
      #| Bedimayuri@gmail.com   | study   | Do your best | D:\\Passport - Mayuri Bedi.pdf |
      | sahumayuri@gmail.com | Wishes  | Best Luck | D:\\Passport - Mayuri Bedi.pdf |
    #| bedimayuri11@gmail.com | CV      | find CV      | D:\\Passport - Mayuri Bedi.pdf |
    When do logout
    Then login page should be displayed
    Then closed site
