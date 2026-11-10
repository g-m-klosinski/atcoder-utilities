void main(String[] args) {
    try {
        var tests = new TaskTests(args);
        tests.dump();
    } catch (Exception ex) {
        IO.println(ex.getMessage());
    }
}
