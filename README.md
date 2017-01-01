#Android-GoogleCloudEndpoint-Connect

This project uses Gradle to build a joke-telling app, factoring functionality into libraries and flavors to keep the build simple. Google Cloud Endpoints development server is configured to supply the jokes.

##Features 
 - This project has java library - joketeller that returns the joke. 
 - The joke is provided through Google Cloud Endpoints.
 - AndroidLibrary displays the joke when it is called in MainActivity.
 - Espresso is used for writing tests
 - Paid and Free version flavours are provided
 - Free version contains **Interstitial Ad**
 - Paid version does not contains Interstitial Ad and uses **Loading Indicator**
 - Gradle scripts for the task that
   - Launches the Google Cloud Endpoint local development server
   - Runs all tests
   - Shuts the server down again

##Run it on your machine
---------------
- **Clone the project**:
  Go to any directory in your machine and run the below command on the terminal:
  ```
  git clone https://github.com/abilaashsai/Android-GoogleCloudEndpoint-Connect.git
  ```

- **Run the project**:
  I use Android Studio. Here you have to _Import_ the project and _Run_ the _Google Cloud Endpoint_ and then _mobile application_.

##Contribution
-------
Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub.

License
-------
The contents of this repository are covered under the [MIT License](https://github.com/abilaashsai/Android-GoogleCloudEndpoint-Connect/blob/master/LICENSE).
