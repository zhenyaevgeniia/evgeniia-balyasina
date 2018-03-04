Test plans are done for Task1 and Task3.

# TASK1

Application: version 1.8.6. Android 7.1.1. Device: Moto G5s.

List of feature according the priority.

#### Assumption 1: most of the users use basic version.

1. Adding data and store it on device:
 - by income/expense/transfer buttons inside the app;
2. Showing correct data taken from device:
 - when app was closed and opened again;
 - when device was restarted.
3. “Money pro” features, check for each feature (because it brings money to the business):
 - unavailable for basic version, click on feature redirects to “Money pro” screen.
4. Accounts:
 - after new account is saved correctly and appears in all related places, ex. add new income screen;
 - when money is transferred from one account to another it doesn't affect the balance and account is reassigned in operation details;
 - when account is updated (ex. name) it doesn't affect the numbers already assigned to that account;
 - not possible OR proper warning message is shown OR operations should be reassigned when user tries to delete account with assigned operations (BUG: when account is deleted all operations also deleted).
5. Categories:
 - list is available for each operation: add expense/income, edit record, open list of categories in menu.
6. Actions with records:
 - edited data stored on device.
 - deleted data is removed completely from device.
7. Create data backup:
 - store the data with new name with version;
 - new backup doesn’t override already existed.
8. Restore data:
 - overrides any changes were made after creation backup;
 - there is a dialog to choose the version;
 - gives a proper error when user tries to restore from corrupted file.
9. Account and time period on hamburger menu:
 - updates the data on main screen correctly;
 - setting is saved after closing app.
10. Currency:
 - changing the currency effects only the way of showing the currency, not the values of numbers.
11. Budget mode:
 - after setting the mode the balance for chosen period is updated according formula: [budget_mode_number]/[chosen_period]
12. Carry over:
 - calculation is a sum from the first day of expenses;
 - number on main screen updates only on next day after added expenses.
13. Language:    
 - all data is updated after chosen language except of notes made by user;
 - doesn't affect the balance.

#### Assumption 2: most of the users use pro version.
1. Adding data and store it on dropbox:
 - by income/expense/transfer buttons inside the app;
 - by using submenu for app.
2. Showing correct data taken from dropbox:
 - when app is launched from background mode;
 - when app was closed and opened again;
 - when device was restarted;
 - when new device is connected for same account.  
3. Dropbox synchronization:
 - if synchronization is available but not set, data is stored on device as with basic functionality;
 - after activation, all data moves from device to dropbox automatically and completely;
 - check the case: dropbox was set, then dropbox account was removed or not available (no place, disallow  - access for Monefy app if possible or similar).
4. Accounts:
 - see Accounts in basic version;
 - after any update in account the data is updated in each connected device.
5. Categories:
 - list is available for each operation: add expense/income, edit record, open list of categories in menu;
 - after add/update new category or delete category without linked data it updates in each list for each synchronized device;
 - when user tries to delete a category with data then it moves to other with specific error message OR proper error message appears.
5. Actions with records:
 - edited data stored on dropbox;
 - the record updated on one device could be updated on another one and be synchronized;  
 - deleted data is removed completely from dropbox.
6. Account and time period on hamburger menu:
 - updates the data on main screen correctly;
 - setting is saved after closing app.
7. Currency:
 - see Currency in basic version;
 - after any update in currently the data is updated in each connected device.
8. Budget mode:
 - see Budget mode in basic version;
 - after any update in currently the data is updated in each connected device.
9. Carry over:
 - see Carry over in basic version);
 - after any update in currently the data is updated in each connected device.
10. Language:    
- see Language in basic version;
- after any update in currently the data is updated in each connected device.
7. “Money pro” features:
 - menu item not visible OR shows that already activated.
8. Create and restore data:
 - see Create and restore data in basic version.


# TASK3

My suggestion to create scenarios for Best Buy API Playground for each listed endpoint with following priority:
1. Healthy check endpoints to check that service works in general.
2. CRUD with valid data for each of endpoint to check that endpoints are working.
3. CRUD with invalid data for each endpoint to check error messages are taken correctly (without 500).
4. Specific situations, such are dependencies.

Point 1 is covered in Utilities.feature.
Points 2 and 3 are covered in Services.feature.

Initially it was a plan to cover 4 by creating feature "Stores" because of connection with "Services".
Example of specific scenario could be following:
 > Scenario: DELETE services used in stores

 >  Given POST services is sent with body

 >  """

 >   "name": "POST service for store"

 >  """

 > And POST stores is sent with body

 > """

 >  "name": "POST store"

 >  ...

 >  "service": {LAST_CREATED_SERVICE}

 > """

 > When DELETE last created service is sent

 > Then .... [here either success either 404, depend on implementation]

Unfortunately, documentation does't provide the way how Stores and Services could be connected.
I've tried in Postman POST http://localhost:3030/stores with body

    {
    "name": "POST stores test",
    ...
    "services":
     {
        "id": 1
     }
    }

Entity was created as a result but with "services": {}.

Possible solutions:
- find the way how services could be linked with stores and update documentation;
- if there is bug here that services should come in post, create a ticket to fix the bug.
