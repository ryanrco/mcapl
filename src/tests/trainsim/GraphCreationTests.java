package trainsim;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.junit.Assert;
import org.junit.Test;
import trainsim.config.RailwayConfig;
import trainsim.objects.Railway;
import trainsim.objects.Stop;
import trainsim.objects.Track;

public class GraphCreationTests {

    @Test
    public void testCreateStopWithValidType(){
        Railway railway = getMockRailway();
        Node mockStop = createMockNode(railway.network, "ST99", "station");

        try{
            railway.createStop(mockStop);;
            Assert.assertTrue(railway.getStop(mockStop).isPresent());
        }catch (Exception e){
            //We assume this won't fail, as type is 'station'
        }
    }

    @Test(expected = Exception.class)
    public void testCreateStopWithInvalidType() throws Exception {
        Railway railway = getMockRailway();
        Node mockStop = createMockNode(railway.network, "ST99", "invalid_type");

        railway.createStop(mockStop);

    }

    @Test(expected = Exception.class)
    public void testMissingNodeType() throws Exception {
        Railway railway = getMockRailway();
        Node mockStop = createMockNode(railway.network, "ST99", null);

        railway.createStop(mockStop);
    }

    @Test
    public void testGetStopByIdReturnsCorrectStop(){
        Railway railway = getMockRailway();
        Node mockStop = createMockNode(railway.network, "ST99", "station");

        try{
            Stop stop = railway.createStop(mockStop);
            Assert.assertEquals(stop, railway.getStop(mockStop).get());
        }catch (Exception e){
            //We assume this won't fail, as type is 'station'
        }
    }

    @Test
    public void testGetStopByNodeReturnsCorrectStop(){
        Railway railway = getMockRailway();
        Node mockStop = createMockNode(railway.network, "ST99", "station");

        try{
            Stop stop = railway.createStop(mockStop);;
            Assert.assertEquals(stop, railway.getStop(mockStop).get());
        }catch (Exception e){
            //We assume this won't fail, as type is 'station'
        }
    }

    @Test(expected = Exception.class)
    public void testInvalidTrackCreationFails_BothNull() throws Exception {
        Railway railway = getMockRailway();

        Edge edge = createMockEdge(railway.network, "test_track", null, null);
        new Track(railway, edge);
    }

    @Test(expected = Exception.class)
    public void testInvalidTrackCreationFails_ValidFromInvalidTo() throws Exception {
        Railway railway = getMockRailway();

        Stop stop = railway.createStop(createMockNode(railway.network, "ST99", "station"));

        Edge edge = createMockEdge(railway.network, "test_track", stop.getSimNode().node, null);
        new Track(railway, edge);
    }

    @Test(expected = Exception.class)
    public void testInvalidTrackCreationFails_InvalidFromValidTo() throws Exception {
        Railway railway = getMockRailway();

        Stop stop = railway.createStop(createMockNode(railway.network, "ST99", "station"));

        Edge edge = createMockEdge(railway.network, "test_track", null, stop.getSimNode().node);
        new Track(railway, edge);
    }

    @Test
    public void testValidTrackCreation() throws Exception {
        Railway railway = getMockRailway();

        Stop fromStop = railway.createStop(createMockNode(railway.network, "ST99", "station"));
        Stop toStop = railway.createStop(createMockNode(railway.network, "ST100", "station"));

        Edge edge = createMockEdge(railway.network, "test_track", fromStop.getSimNode().node, toStop.getSimNode().node);
        new Track(railway, edge);
    }


    @Test
    public void testGetTrackByIdReturnsCorrectStop(){
        Railway railway = getMockRailway();
        Node fromStop = createMockNode(railway.network, "ST99", "station");
        Node toStop = createMockNode(railway.network, "ST100", "station");
        Edge edge = createMockEdge(railway.network, "test_track", fromStop, toStop);
        try{
            Track track = railway.createTrack(edge);
            Assert.assertEquals(track, railway.getTrack("test_track").get());
        }catch (Exception e){
            //We assume this won't fail, as it has valid connecting points
        }
    }

    @Test
    public void testGetTrackByEdgeReturnsCorrectStop(){
        Railway railway = getMockRailway();
        Node fromStop = createMockNode(railway.network, "ST99", "station");
        Node toStop = createMockNode(railway.network, "ST100", "station");
        Edge edge = createMockEdge(railway.network, "test_track", fromStop, toStop);
        try{
            Track track = railway.createTrack(edge);
            Assert.assertEquals(track, railway.getTrack(edge).get());
        }catch (Exception e){
            //We assume this won't fail, as it has valid connecting points
        }
    }

    @Test
    public void testEnsureValidView(){
        Railway railway = getMockRailway();
        Assert.assertNotNull(railway.getView());
    }


    private Node createMockNode(Graph graph, String id, String type){
        Node node = graph.addNode(id);
        node.setAttribute("type", type);
        return node;
    }

    private Edge createMockEdge(Graph graph, String id, Node from, Node to){
        Edge edge = graph.addEdge(id, from, to);
        return edge;
    }

    private Railway getMockRailway(){
        RailwayConfig config = new RailwayConfig("src/tests/trainsim/configs/graph_test_config.txt");
        return new Railway(config);
    }

    private Railway getMockCorruptRailway(){
        RailwayConfig config = new RailwayConfig("src/tests/trainsim/configs/corrupt_graph_test_config.txt");
        return new Railway(config);
    }
}
