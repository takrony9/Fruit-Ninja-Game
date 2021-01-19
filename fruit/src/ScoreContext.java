public class ScoreContext {
    private Iscore Iscore;
    public ScoreContext(Iscore Iscore){
        this.Iscore=Iscore;
    }
    public int excuteScore(int Score)
    {
        return Iscore.calculateScore(Score);
    }
}
