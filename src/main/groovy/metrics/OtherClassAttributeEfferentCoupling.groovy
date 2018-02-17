/**
 * The MIT License (MIT)
 *
 * MSUSEL Metrics
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package metrics

import edu.montana.gsoc.msusel.codetree.node.AbstractNode
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode
import metrics.annotations.*

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
@MetricDefinition(
        name = "Other Class Attribute Interaction Efferent Coupling",
        primaryHandle = "OCAEC",
        description = "Count of all class attribute interactions from non-descendent and non-friend classes to the measured class.",
        properties = @MetricProperties(
                range = "Positive Integer",
                aggregation = [],
                scope = MetricScope.TYPE,
                type = MetricType.Model,
                scale = MetricScale.Interval,
                category = MetricCategory.Coupling
        ),
        references = [
                'Briand, Lionel, Prem Devanbu, and Walcelio Melo. "An investigation into coupling measures for C++." Proceedings of the 19th international conference on Software engineering. ACM, 1997.',
                'Briand, Lionel C., John W. Daly, and Jurgen K. Wust. "A unified framework for coupling measurement in object-oriented systems." IEEE Transactions on software Engineering 25.1 (1999): 91-121.'
        ]
)
class OtherClassAttributeEfferentCoupling extends AbstractMetric {

    /**
     *
     */
    OtherClassAttributeEfferentCoupling() {
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    def measure(AbstractNode node) {
        int total = 0

        if (node instanceof TypeNode) {
            Set desc = []
            desc += tree.getAssociationsTo(node)
            desc += tree.getAggregationsTo(node)
            desc += tree.getCompositionsTo(node)

            desc.removeAll(tree.getAllDescendentClasses(node))

            desc.each { d ->
                def fieldTypes = d.fields().collect {
                    it.getType()
                }
                total += fieldTypes.findEach { it == node }
            }
        }

        total
    }

}
