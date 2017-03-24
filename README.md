# Event Planning

#### Event Planning Cost Builder, Current Version: 03/24/2017

#### By Gloria Friesen

## Description
This Java web application allows the user to build a hack-a-thon team.

## Setup/Installation Instructions
* In your web browser of choice, go to: <http://github.com/GloriaFriesen/team-organizer>
* Clone repository
* In terminal
  * Switch to team-organizer directory
  * To run the program, use command $ gradle run
  * In your browser, go to localhost:4567
  * Add teams and members

## Specifications

|Behavior|Input|Output|
|:---:|:---:|:---:|
|Application instantiates Team class|team|true|
|Application instantiates Team class with name|"Team TOT"|"Team Tot"|
|Application returns all instances of Team class|"Team TOT", "A Team"|"Team TOT", "A Team"|
|Application empties all teams from list of team|"Team TOT"|0|
|Application assigns an ID to each instance of team class|"Team TOT"|1|
|Application finds instance of team class with the same ID|2|"A Team"|
|Application instantiates Member class|member|true|
|Application instantiates Member class with name|"Abby"|"Abby"|
|Application returns all instance of Member class|"Abby", "Pepper Jack"|"Abby", "Pepper Jack"|
|Application empties all members from list of member|"Abby"|0|
|Application assigns an ID to each instance of member class|"Abby"|1|
|Application finds instance of member class with the same ID|2|"Pepper Jack"|

## Known Bugs
We'll see.

## Support and contact details
Questions? Concerns? Suggestions? Reach out to me via github: <https://github.com/GloriaFriesen>.

## Technologies Used
* _Java_
* _Gradle_
* _JUnit_
* _Spark_
* _Velocity_

## License
This software is licensed under the MIT license.
Copyright (c) 2017 Gloria Friesen.
