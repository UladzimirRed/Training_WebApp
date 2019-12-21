package by.epam.training.command;

public class CommandResult {
    private String page;
    private boolean isRedirect;

    public CommandResult() {
    }

    public CommandResult(String page) {
        this.page = page;
    }

    public CommandResult(String page, boolean isRedirect) {
        this.page = page;
        this.isRedirect = isRedirect;
    }

    public String getPage() {
        return page;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandResult that = (CommandResult) o;

        if (isRedirect != that.isRedirect) return false;
        return page != null ? page.equals(that.page) : that.page == null;
    }

    @Override
    public int hashCode() {
        int result = page != null ? page.hashCode() : 0;
        result = 31 * result + (isRedirect ? 1 : 0);
        return result;
    }
}
