/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.*/
class Solution
{
private:
    ListNode* merge(ListNode *m_l1, ListNode *m_l2)
    {
        auto head = new ListNode();
        auto iter = head;
        while(m_l1 && m_l2)
        {
            iter->next = (m_l1->val < m_l2->val ? m_l1 : m_l2);
            iter = iter->next;
            
            m_l1->val < m_l2->val ? m_l1 = m_l1->next : m_l2 = m_l2->next;
        }
        
        iter->next = (m_l1 ? m_l1 : m_l2);
        return head->next;
    }
public:
    ListNode* mergeKLists(vector<ListNode*> &m_lists)
    {
        if(m_lists.empty()) return nullptr;
        
        vector<ListNode*> mergedLists;
        while(m_lists.size() > 1)
        {
            for(int left = 0, right = m_lists.size() - 1; left <= right; left++, right--)
            {
                if(left == right) mergedLists.push_back(m_lists[left]);
                else mergedLists.push_back(merge(m_lists[left], m_lists[right]));
            }
            
            swap(m_lists, mergedLists);
            mergedLists.clear();
        }
        
        return m_lists.front();
    }
};
