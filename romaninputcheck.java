import java.util.ArrayList;

public class romaninputcheck {
    protected String roman;
    protected ArrayList<String> groups= new ArrayList<>();
    protected ArrayList<Integer> valus= new ArrayList<>();

    public romaninputcheck(String roman)
    {
        this.roman=roman;
    }

    public boolean checksize()
    {
        if(1<=roman.length() && roman.length()<=15)
        {
            return true;
        }
        return false;
    }

    public boolean checkletters()
    {
        boolean check=true;
        for(int i=0; i<roman.length(); i++)
        {
            char c=roman.charAt(i);
            if(c=='I' || c=='V' || c=='X' || c=='L' || c=='C' || c=='D' || c=='M')
            {
                continue;
            }
            check=false;
            break;
        }
        return check;
    }

    public int getletters()
    {
        int total=0;
        for(int i=0; i<roman.length()-1; i++)
        {
            char c=roman.charAt(i);
            char d=roman.charAt(i+1);
            switch (c) {
                case 'I':
                {
                    if(d=='V' || d=='X')
                        total+=-1;
                    else
                        total+=1;
                    break;
                }
                case'V':
                {
                    total+=5;
                    break;
                }
                case'X':
                {
                    if(d=='L' || d=='C')
                        total+=-10;
                    else
                        total+=10;
                    break;
                }
                case'L':
                {
                    total+=50;
                    break;
                }
                case'C':
                {
                    if(d=='D' || d=='M')
                        total+=-100;
                    else
                        total+=100;
                    break;
                }
                case'D':
                {
                    total+=500;
                    break;
                }
                case'M':
                {
                    total+=1000;
                    break;
                }
            }
        }
        total=total+checkvalue(roman.charAt(roman.length()-1));
        return total;
    }

    public int checkvalue(char c)
    {
        switch (c) 
        {
            case 'I':
                {
                    return 1;
                }
            case'V':
                {
                    return 5;
                }
            case'X':
                {
                    return 10;
                }
            case'L':
                {
                    return 50;
                }
            case'C':
                {
                    return 100;
                }
            case'D':
                {
                    return 500;
                }
            case'M':
                {
                    return 1000;
                }
            default:
                {
                    return 0;
                }
        }
    }
    
    public void explain()
    {
        int i=0;
        while(i<roman.length())
        {
            if(i+1<roman.length() && checkvalue(roman.charAt(i))<checkvalue(roman.charAt(i+1)))
            {
                String group=roman.substring(i,i+2);
                int val= checkvalue(roman.charAt(i+1))-checkvalue(roman.charAt(i));
                this.groups.add(group);
                this.valus.add(val);
                i+=2;
            }
            else
            {
                char current=roman.charAt(i);
                int start= i;
                while(i+1<roman.length() && roman.charAt(i+1)==current)
                {
                    i++;
                }
                String group= roman.substring(start,i+1);
                int val= checkvalue(current)*(i-start+1);
                this.groups.add(group);
                this.valus.add(val);
                i++;
            }
        }
    }

    public void printtheresult()
    {
        System.out.print("Explain: ");
        for(int i=0; i<groups.size(); i++)
        {
            System.out.print("\""+groups.get(i)+"\"= "+valus.get(i)+"  ");
        }
    }
}
