# ANSWER FOR QUESTIONS IN CHOOSING OPTION #

## 1. What happens if users choose "Cancel"? ##

**Answer:** If the user chooses `Cancel`, the `showConfirmDialog` method returns an integer value of 2, which corresponds to the constant `JOptionPane.CANCEL_OPTION`. In the provided sample code, since the program only checks if option == JOptionPane.YES_OPTION, clicking `Cancel` will result in the `No` message being displayed (because the condition is false), and then the program will terminate.

## 2. How to customize the options to users (e.g., only "Yes" and "No", or "I do" and "I don’t")? ##

**Answer:** 
* To show only "Yes" and "No": We can change the optionType parameter in the showConfirmDialog method.
* Code change: int option = JOptionPane.showConfirmDialog(null, "Message", "Title", JOptionPane.YES_NO_OPTION);
* To use custom labels like "I do" and "I don’t": We need to use the showOptionDialog method, which allows passing an array of Strings as the button labels.
* Example:
```java
Object[] options = {"I do", "I don't"};
int n = JOptionPane.showOptionDialog(null,
    "Do you want to proceed?",
    "Selection",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,    
    options,  
    options[0]);
```