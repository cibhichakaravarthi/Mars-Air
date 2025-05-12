# Mars-Air
Cucumber Local Report Generation Guide
This guide will help you set up Cucumber reports to be generated locally after test execution.

Prerequisites
Before starting, make sure you have the following:

Java Development Kit (JDK): Ensure you have JDK installed.

Maven: Your project should use Maven for building.

Cucumber Framework: Set up Cucumber with Java for running tests.

Steps for Generating Cucumber Reports Locally
1. Add Required Dependencies
You need to add the necessary dependencies for Cucumber and Cucumber Reporting in your project's pom.xml file.

Cucumber Java: To enable running Cucumber tests.

Cucumber Reporting: For generating reports after test execution.

2. Configure Cucumber Options for Report Generation
In your Cucumber runner class:

Define the paths for output reports (both JSON and HTML).

The JSON format will hold detailed execution results, while HTML will be used for a more user-friendly, human-readable report.

3. Generate HTML Report from JSON
After test execution, use the Cucumber Reporting tools to convert the generated JSON report into an HTML report. This HTML file will be saved locally on your machine.

4. Run the Tests
Execute your tests through your preferred method (IDE, Maven, etc.).

The JSON report will be created at a specified location (e.g., target/cucumber-report/cucumber.json).

The HTML report will be created and saved locally (e.g., target/cucumber-report/cucumber_report.html).

5. View the Report Locally
Once the tests are completed:

Navigate to the generated HTML report file location.

Open the HTML report in any browser to view the test execution details and results.

Troubleshooting
Here are a few common issues and solutions:

No report is generated: Ensure that your paths for JSON and HTML files are correctly defined in your configuration.

Driver setup issues: Double-check your WebDriver setup (e.g., ChromeDriver) to ensure the tests run smoothly.

Conclusion
With these steps, you can easily generate Cucumber reports locally without needing to rely on external services like Cucumber.io. The generated HTML report provides a user-friendly format that you can open directly in any web browser to review your test results.

Additional Resources
Cucumber Documentation: Cucumber Official Docs

Maven Documentation: Maven Official Docs
