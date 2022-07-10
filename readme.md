# Overview

My main goal while making this application was to keep it as functionally simple as possible while
still adhering to good practices and clean testable code. To achieve this I stuck to a pretty
standard Android MVVM architecture with Jetpack Compose as the View layer. Specifics that might look
a little different at first glance would be as follows:

- The Service Manager layer which is normally absent in a lot of applications. I add this in
  situations where we don't have control over the api or it is being used by applications with
  different needs to our application. Its primary function is to sequester the API data objects and
  convert them into the data objects we use in the rest of the application. This does add some
  complexity at that layer to do the transition, but hopefully it decreases the complexity in the
  rest of the application by not having fields or structures that we don't care about. It also makes
  it less cumbersome if the API changes object structures by making it so that change only affects
  this layer.
- The lack of a Repository layer. In this application I am not saving the articles locally, so I
  only have one source of data that I do not need to coordinate. In that situation, the Repository
  would just be a pass-through to the Service Manager and I don't want a Repository just to have
  one. In the case where another data source was being added, the Repository would be the first
  thing I added.

If I were to spend more time on the project the things I would focus on in a rough order of priority
would be:

- Automated Testing. I haven't done much testing based in Jetpack Compose, so I decided that for the
  sakes of this project I would prioritize using Jetpack Compose over adding my normal level of
  testing. I still kept testing in mind for my architecture and general coding, but that would be
  number one on my list before adding any new features.
- API paging on scroll because users probably want more than 10 articles at a time. Not particularly
  complicated, would use the Jetpack Paging library's Compose support and add in a Compose
  ScrollState listener and an additional query param to the api call for which page we're on
- An actual Material Theme. If I were making this in a team, I would rely on the designers to supply
  me with the colors and typography that they would want the most. If I was doing this by myself
  with the intention of it being a public facing application I would spend time testing out
  different colors and theming before deciding on what looked the best to me. Along with this would
  be a real light/dark theme rather than the one that came for free in the template.
- A dropdown with checkboxes to select the categories that app is filtering from NYT. On the data
  end this would be pretty simple as just having a sealed class for each news desk category, and
  building the query string from the ones selected, but I didn't want to add more work for myself in
  this sample than I needed to.
- I would not implement saving the articles to read them offline, due to the fact that from the NYT
  API the only bit of the article that the user can read is the first paragraph. They need to go to
  the NYT website to actually read the article, and they can't do that without web access. I suppose
  we could store the links to the articles as a "Read Later" list, but that doesn't solve the
  problem of allowing users to read the articles offline. Perhaps there is something in the API or
  another API call that I am missing, but this doesn't seem like a particularly useful feature for
  our users to me.