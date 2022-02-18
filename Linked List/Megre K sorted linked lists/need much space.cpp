class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode *temp = NULL;
        priority_queue<int, vector<int>, greater<int>> v;
        for (auto it : lists)
        {
            temp = it;
            while (temp != NULL)
            {
                v.push(temp->val);
                temp = temp->next;
            }
        }
        ListNode *head = new ListNode(-1);
        temp = head;
        while (!v.empty())
        {
            temp->next = new ListNode(v.top());
            temp = temp->next;
            v.pop();
        }
            return head->next;
    }
};

