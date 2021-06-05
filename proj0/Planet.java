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

    public double calcForceExertedByX(Planet b) {
        double dx = b.xxPos - xxPos;
        return calcForceExertedBy(b) * dx / calcDistance(b);
    }

    public double calcForceExertedByY(Planet b) {
        double dy = b.yyPos - yyPos;
        return calcForceExertedBy(b) * dy / calcDistance(b);
    }

    public double calcNetForceExertedByX(Planet[] bs) {
        double sum_x = 0;

        for (Planet b : bs) {
            if (b.equals(this))
                continue;
            sum_x += calcForceExertedByX(b);
        }
        return sum_x;
    }


    public double calcNetForceExertedByY(Planet[] bs) {
        double sum_y = 0;

        for (Planet b : bs) {
            if (b.equals(this))
                continue;
            sum_y += calcForceExertedByY(b);
        }
        return sum_y;
    }

    public void update(double dt, double fX, double fY) {
        xxVel += fX / mass * dt;
        yyVel += fY / mass * dt;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
        StdDraw.show();
    }
}
