class Logger {
    private HashMap<String, Integer> msgDict;

    public Logger() {
        msgDict = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.msgDict.containsKey(message)) {
            this.msgDict.put(message, timestamp);
            return true;
        }

        Integer oldTimestamp = this.msgDict.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.msgDict.put(message, timestamp);
            return true;
        } else return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */