/**
 * 
 */
package com.sparqline.metrics.system;

import java.util.HashSet;
import java.util.Set;

import com.sparqline.graph.CodeGraph;
import com.sparqline.graph.ProgramNode;
import com.sparqline.graph.nodes.SystemNode;
import com.sparqline.graph.nodes.body.FieldNode;
import com.sparqline.graph.nodes.type.ClassOrInterfaceNode;
import com.sparqline.metrics.MetricScope;
import com.sparqline.metrics.SystemMetric;

/**
 * MOA - Member Object Attributes
 * 
 * @author Isaac Griffith
 */
public class MOA extends SystemMetric {

    /**
     * 
     */
    private static final long serialVersionUID = -8931062165967836327L;

    public static MOA getInstance(final ProgramNode entity, final CodeGraph graph)
    {
        return new MOA("Average Member Object Attributes", "", "MOA", MetricScope.SystemLevel, entity, graph);
    }

    private MOA(final String name, final String desc, final String acronym, final MetricScope scope,
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
        double value = 0.0d;

        if (entity instanceof SystemNode)
        {
            final SystemNode sys = (SystemNode) entity;
            final Set<ProgramNode> systemClasses = new HashSet<>();
            systemClasses.addAll(sys.getClasses());

            double totalMOA = 0.0d;
            for (ProgramNode ce : systemClasses)
            {
                Set<String> typeNames = new HashSet<>();
                if (ce instanceof ClassOrInterfaceNode)
                {
                    ClassOrInterfaceNode cie = (ClassOrInterfaceNode) ce;
                    Set<FieldNode> fields = cie.getFields();

                    for (FieldNode f : fields)
                    {
                        if (f.isPrimitive() == false)
                            continue;
                        totalMOA++;
                    }
                }
            }

            value = totalMOA / systemClasses.size();
        }
        if (Double.isNaN(value))
            value = 0;
        return value;
    }
}
