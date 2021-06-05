public class Planet {
    double xxPos, yyPos, xxVel, yyVel, mass;
    String imgFileName;
    static final double gravity = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        double dx = xxPos - b.xxPos;
        double dy = yyPos - b.yyPos;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double calcForceExertedBy(Planet b) {
        return gravity * mass * b.mass / Math.pow(calcDistance(b),2);
    }
}
