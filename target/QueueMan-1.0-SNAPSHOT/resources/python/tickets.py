import requests
import sys

# Set the request parameters
url = 'https://cliqr.zendesk.com/api/v2/views/44786935/execute.json'
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
print("<tr><th>Ticket Number</th><th>Ticket Owner</th><th>Ticket Type</th><th>Ticket Subject</th><th>Time to Breach in Hours</th><th>Time to Breach in Minutes</th>")
group_list = data['rows']
for group in group_list:
    if group['sla_next_breach_at'] != None:
        url1 = 'https://cliqr.zendesk.com/api/v2/users/' + str(group['assignee_id']) + '.json'
        response1 = requests.get(url1, auth=(user, pwd))
        data1 = response1.json()
        users_list = data1['user']
        print("<tr><td><a href=\"https://cliqr.zendesk.com/agent/tickets/"+str(group['ticket']['id']) + "\" target==\"_blank\">" + str(group['ticket']['id']) + "</a></td><td>" + str(users_list['name']) + "</td><td>" + group['ticket']['type'] + "</td><td>" + str(group['subject'])  + "</td><td>" + str(group['ticket']['sla_policy_metric'].get('hours')) + "</td><td>" + str(group['ticket']['sla_policy_metric'].get('minutes')) + "</td>" + "</tr>")
print("</table>")
