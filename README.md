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
* Add new data to the task class
* Add a 'clear all' button and its functionality
* Add log messages
* Highlight task when its end date is close or reached

## Hard
* Export data as CSV
	* Add option to select between export methods
* Add a 'confirm delete' dialog to the delete function
* Add file -> Set export path button and its functionality

