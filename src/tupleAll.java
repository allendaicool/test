

public class tupleAll<X,Y> {
	
	private X temp1;
	private Y temp2;
	public tupleAll (X val, Y val2)
	{
		this.temp1 = (X)val;
		this.temp2 =(Y) val2;
		
	}
	
	public X xVal()
	{
		return this.temp1;
	}
	public Y yval()
	{
		return this.temp2;
	}
	/*@Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof tupleAll)){
            return false;
        }
        tupleAll<X,Y> other_ = (tupleAll<X,Y>) other;
        return other_.x == this.x && other_.y == this.y;
    }*/
	

}

