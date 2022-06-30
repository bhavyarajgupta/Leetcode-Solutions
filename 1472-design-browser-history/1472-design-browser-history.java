class BrowserHistory {
    List<String> list;
    int index = 0;
    int size = 0;
    
    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        size = 0;
    }
    
    public void visit(String url) {
        if(index + 1 == list.size()) list.add(null);
        list.set(index + 1, url);
        index++;
        size = index;
    }
    
    public String back(int steps) {
        index = Math.max(index - steps, 0);
        return list.get(index);
    }
    
    public String forward(int steps) {
        index = Math.min(index + steps, size);
        return list.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */