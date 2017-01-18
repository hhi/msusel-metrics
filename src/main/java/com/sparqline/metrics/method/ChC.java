package com.sparqline.metrics.method;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.body.MethodNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MethodMetric;
import com.sparqline.metrics.MetricScope;

/**
 * ChC - Changing Classes. The number of classes in which the methods that call
 * the measured method are defined in.
 * 
 * @author Isaac Griffith
 */
public class ChC extends MethodMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8262232065429977580L;

    /**
     * @param entity
     * @param graph
     * @return
     */
    public static ChC getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new ChC("Changing Classes",
                "The number of classes in which the methods that call the measured method are defined in.", "ChC",
                MetricScope.MethodLevel, entity, graph);
    }

    /**
     * @param name
     * @param desc
     * @param acronym
     * @param scope
     * @param entity
     * @param graph
     */
    private ChC(final String name, final String desc, final String acronym, final MetricScope scope,
            final ProgramNode entity, final CodeGraph graph)
    {
        super(name, desc, acronym, scope, entity, graph);
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#measure()
     */
    @Override
    public double measure()
    {
        double chc = 0;

        final MethodNode method = (MethodNode) entity;
        ClassOrInterfaceNode methodOwner = (ClassOrInterfaceNode) tree.getMethodOwner(method);
        Set<ProgramNode> others = new HashSet<>();
        others.addAll(tree.getMethods());
        others.remove(method);
        List<ClassOrInterfaceNode> owners = new LinkedList<>();

        for (ProgramNode pe : others)
        {
            MethodNode other = (MethodNode) pe;
            if (other.getCallOwners().contains(methodOwner))
                owners.add((ClassOrInterfaceNode) tree.getMethodOwner(other));
        }

        return chc = owners.size();
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.truerefactor.metrics.Metric#setPrerequisites()
     */
    @Override
    public void setPrerequisites()
    {
        double CDISP = taskMap.containsKey("CDISP") ? taskMap.get("CDISP").join().getValue() : entity.getMetric("DISP");
    }
}
