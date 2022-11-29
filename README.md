
# Setup for IntelliJ
* Eclipse Adoptium Adapt OpenJDK 11 Hotspot

### Setting up SceneBuilder
* Open .fxml file
* below the editor switch to the SceneBuilder tab
* If there is an error message with a download option, click download and restart the IDE

# Setup for Eclipse IDE 2022-09
* Use Eclipse Adoptium Adapt OpenJDK 11 Hotspot
* Move Project and External Dependencies to Modulepath (Gradle refresh will move them back to Classpath)

### Setting up SceneBuilder
* Download the SceneBuilder installer from gluon's official website
* Install SceneBuilder with the installer
* In eclipse install the 'e(fx)clipse 8' plugin
* Restart Eclipse
* In Eclipse go to Preferences -> JavaFX
* Set the path to the SceneBuilder executable (most likely under 'AppData\Local\SceneBuilder')
* Restart Eclipse
* Right click .fxml file and select open in SceneBuilder

# Tasks
## Easy
* Add a new attribute to the task class
	* Add the attribute to the class
	* Extend the fxml layout to support a checkbox with the tag 'Important'
	* Add the attribute to the task object when writing the form values to the object
* Add a new 'Clear all' button to the file menu in the menubar
	* Add the button to the menu bar
	* Create a new method 'clickDeleteAll' in the MainController
	* Button removes all task objects and clears the file
* Add log messages to the DataController when adding, removing or updating a task

## Hard
* Add a new way to export data into a CSV file
	* Add the dependency for the OpenCSV libary
	* Add the corresponding methods in the Datacontroller
	* Add a new button to the File menu in the Menubar
		* This button opens a Dialog where the user can select between JSON and CSV export
* Add a 'confirm delete' dialog to the delete function
* Add a new button to the file menu in the menubar to set a specified export path

