class FreqStack {
    TreeSet<E> ts;
    Map<Integer, E> mp;
    int cnt;
    
    public FreqStack() {
        mp = new HashMap<>();
        ts = new TreeSet<>();
        cnt = 0;
    }
    
    public void push(int x) {
        E e;
        if (!mp.containsKey(x)) {
            e = new E(x);
        } else {
            e = mp.get(x);
            ts.remove(e);
        }
        e.add(cnt++);
        ts.add(e);
        mp.put(x, e);
    }
    
    public int pop() {
        E e = ts.pollFirst();
        int ans = e.remove();
        ts.add(e);
        return ans;
    }
    
    class E implements Comparable<E> {
        int num;
        LinkedList<Integer> lst;
        public E(int num) {
            this.lst = new LinkedList<>();
            this.num = num;
        }
        public void add(int idx) {
            lst.add(idx);
        }
        public int remove() {
            lst.pollLast();
            return this.num;
        }
        public int size() {
            return this.lst.size();
        }
        public int getLast() {
            return this.lst.getLast();
        }

        @Override
        public int compareTo(E e) {
            if (e.size() != 0 && e.size() == this.lst.size()) {
                return e.getLast() - this.lst.getLast();
            }
            return e.size() - this.lst.size();
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
