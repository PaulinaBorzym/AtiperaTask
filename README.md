The application finds all non-fork repositories and returns their name, owner's login and a list of branches with their names and commit sha.
It handles errors related to non-existent user and invalid accept in header.
To check the operation of the application after its launch, just send a request to the link http://localhost:<port_number>/api/repositories/<user_name>.
