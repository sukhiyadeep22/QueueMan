import requests
import pytz
import sys

from datetime import datetime, timedelta
from pytz import timezone
fmt = "%Y-%m-%d %H:%M:%S"
# Set the request parameters
url = 'https://cliqr.zendesk.com/api/v2/views/49997386/execute.json'
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

print("<table class=\"table table-striped\">")
print("<tr><th>Ticket Owner</th><th>Ticket Number</th><th>Ticket Priority</th><th>Days Since Followed Up</th>")
group_list = data['rows']
for group in group_list:
	if str(group['ticket']['status']) == "pending" or str(group['ticket']['status']) == "open" or str(group['ticket']['priority']) == "low" or str(group['ticket']['priority']) == "normal":
	    time_now = datetime.now()
	    ticket_updated = datetime.strptime(group['updated'],'%Y-%m-%dT%H:%M:%SZ') 
	    diff = time_now - ticket_updated
	    if diff > timedelta(days=2):
		 url1 = 'https://cliqr.zendesk.com/api/v2/users/' + str(group['assignee_id']) + '.json'
	         response1 = requests.get(url1, headers=headers)
        	 data1 = response1.json()
	         users_list = data1['user']
		 print("<tr><td>" + str(users_list['name']) + "</td><td><a href=\"https://cliqr.zendesk.com/agent/tickets/"+str(group['ticket']['id'])+ "\" target=\"_blank\">" + str(group['ticket']['id']) + "</a></td><td>" +str(group['ticket']['priority']) +"</td><td>"+ str(diff.days) + "</td></tr>")
print("</table>")
#    print(str(group['created']))

#    print now_time.strftime(fmt)
