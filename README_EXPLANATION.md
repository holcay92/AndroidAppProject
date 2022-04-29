In this project, I tried to use MVVM features. I created a member class as a model, fetched the json file via Gson library. 

I used Recycler View fragment as a view. It also satisfies the single responsibility rule of the OOP SOLID principles.

I keep the data in an arraylist. There are three activity layouts: Main, Detail and Member.

In the main layout, the program fetches the data from json file and uses recycler view as a viewing tool.

You can use the search filter to look for a specific member. By clicking on any of the member names, the app goes to the Detail layout of this very member.

In here, detailed informations are shown. On the main layout clicking on the add new member button opens third layout, Member.

In here you can fill the new member's information and by clicking save button the app saves the new member into the arraylist.

if there are any duplicates or any input errors with try-catch the program doesn't save the new member and returns back to main layout.


References:

https://developer.android.com/kotlin

https://developer.android.com/guide/topics/ui/layout/recyclerview

https://www.geeksforgeeks.org/android-recyclerview-in-kotlin/

https://developer.android.com/reference/android/widget/LinearLayout

https://github.com/codeWithCal/CardRecyclerViewTutorial/blob/master/app/src/main/java/code/with/cal/cardviewrecyclerviewtutorial/MainActivity.kt

https://tutorials.eu/json-parsing-and-how-to-use-gson-in-android/#ftoc-heading-10

https://johncodeos.com/how-to-add-search-in-recyclerview-using-kotlin
