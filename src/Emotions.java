   // import com.fasterxml.jackson.core.JsonParseException;

public class Emotions
{
	faceRectangle faceRectangle;
	scores scores;
	
	public Emotions()
	{
		
	}

	public faceRectangle getFaceRectangle() {
		return faceRectangle;
	}

	public void setFaceRectangle(faceRectangle faceRectangle) {
		this.faceRectangle = faceRectangle;
	}

	public scores getScores() {
		return scores;
	}

	public void setScores(scores scores) {
		this.scores = scores;
	}

}
