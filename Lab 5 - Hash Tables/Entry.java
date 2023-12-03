public class Entry
{
    private Dollar data;
    public Entry()
    {
        data = null;
    }
    public Entry(Dollar val)
    {
        data = val;
    }

    public void setData(Dollar val)
    {
        data = val;
    }

    public Dollar getData()
    {
        return data;
    }
}