#Android-GoogleCloudEndpoint-Connect

1. This project has java library - joketeller that returns the joke. 
2. The joke is provided through Google Cloud Endpoints.
3. AndroidLibrary displays the joke when it is called in MainActivity.
4. Espresso is used for tests
5. paid and free versions are provided
6. Free version contains Interstitial Ad
7. Paid version does not contains Interstitial Ad and uses Loading Indicator
8. Gradle task that

i. Launches the GCE local development server
ii. Runs all tests
iii. Shuts the server down again
