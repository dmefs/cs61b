public class NBody {
    
    public static double readRadius(String s) {
        In in = new In(s);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] ps = new Planet[num];

        for (int i = 0; i < num; i++) {
            ps[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
        }
        return ps;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] ps = readPlanets(filename);
        double time = 0;

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();
        for (Planet p : ps)
            p.draw();
        double [] xForces = new double[ps.length];
        double [] yForces = new double[ps.length];

        do {
            for (int i = 0; i < ps.length; i++) {
                xForces[i] = ps[i].calcNetForceExertedByX(ps);
                yForces[i] = ps[i].calcNetForceExertedByY(ps);
            }
            for (int i = 0; i < ps.length; i++)
                ps[i].update(dt, xForces[i], yForces[i]);

            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (Planet p : ps)
                p.draw();
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        } while (time < T);

        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", ps[i].xxPos, ps[i].yyPos,
                    ps[i].xxVel, ps[i].yyVel, ps[i].mass, ps[i].imgFileName);
        }
    }
}
