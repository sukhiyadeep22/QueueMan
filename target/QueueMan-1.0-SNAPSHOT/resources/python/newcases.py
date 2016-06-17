import requests
import sys

# Set the request parameters
url = 'https://cliqr.zendesk.com/api/v2/views/29466998/execute.json'
user = 'dsukhiya@cliqr.com'
headers = {"Authorization": "bearer " + sys.argv[1]}

# Do the HTTP get request
response = requests.get(url, headers=headers)

# Check for HTTP codes other than 200
if response.status_code != 200:
    print('Status:', response.status_code, 'Problem with the request. Exiting.')
    exit()

# Decode the JSON response into a dictionary and use the data
data = response.json()

print("<table class=\"tableside table-stripped table\"> ")
print("<tr class=\"tr\"><th>Ticket Number</th><th>Ticket Priority</th><th>Ticket Subject</th><th>Ticket Status</th>")
group_list = data['rows']
for group in group_list:
    print("<tr><td><a href=\"https://cliqr.zendesk.com/agent/tickets/"+str(group['ticket']['id'])+ "\" target=\"_blank\">" + str(group['ticket']['id']) + "</a></td><td>" + group['priority'] + "</td><td>" + str(group['subject']) + "</td><td>" + str(group['ticket']['status']) + "</td></tr>")
print("</table>")

