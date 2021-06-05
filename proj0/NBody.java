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

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();
        for (Planet p : ps)
            p.draw();
    }
}
