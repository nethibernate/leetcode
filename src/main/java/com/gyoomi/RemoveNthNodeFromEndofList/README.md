## 19. 删除链表的倒数第N个节点

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

```text
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```

说明：

>给定的 n 保证是有效的。

进阶：

>你能尝试使用一趟扫描实现吗？

**方法一：两次遍历算法**

**思路**

我们注意到这个问题可以容易地简化成另一个问题：删除从列表开头数起的第 (L - n + 1) 个结点，其中 L 是列表的长度。只要我们找到列表的长度 L，这个问题就很容易解决。

**算法**

首先我们将添加一个哑结点作为辅助，该结点位于列表头部。哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。在第一次遍历中，我们找出列表的长度 L。然后设置一个指向哑结点的指针，并移动它遍历列表，直至它到达第 (L - n) 个结点那里。我们把第 (L - n) 个结点的 next 指针重新链接至第 (L - n + 2) 个结点，完成这个算法。

**实现代码**

```java
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
```

**复杂度分析**










































