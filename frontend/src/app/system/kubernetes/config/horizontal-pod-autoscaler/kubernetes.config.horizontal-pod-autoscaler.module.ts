import {NgModule} from "@angular/core";
import {CommonModule, DatePipe, KeyValuePipe} from "@angular/common";
import {KubernetesComponentsListModule} from "../../components/list/kubernetes.components.list.module";
import {MatMenuModule} from "@angular/material/menu";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {RouterModule} from "@angular/router";
import {LoaderModule} from "../../../../components/loader/loader.module";
import {MatExpansionModule} from "@angular/material/expansion";
import {FormContainerModule} from "../../../../components/form/container/form.container.module";
import {
  FormMultipleContainerModule
} from "../../../../components/form/multiple-container/form.multiple-container.module";
import {MatChipsModule} from "@angular/material/chips";
import {TableModule} from "primeng/table";
import {
  KubernetesConfigHorizontalPodAutoscalerListComponent
} from "./list/kubernetes.config.horizontal-pod-autoscaler.list.component";
import {
  KubernetesConfigHorizontalPodAutoscalerDetailComponent
} from "./detail/kubernetes.config.horizontal-pod-autoscaler.detail.component";
import {KubernetesConfigHorizontalPodAutoscalerService} from "./kubernetes.config.horizontal-pod-autoscaler.service";
import {
  KubernetesConfigHorizontalPodAutoscalerDetailMetricComponent
} from "./detail/metric/kubernetes.config.horizontal-pod-autoscaler.detail.metric.component";
import {MatDividerModule} from "@angular/material/divider";
import {KubernetesEventModule} from "../../events/kubernetes.event.module";

@NgModule({
  declarations: [
    KubernetesConfigHorizontalPodAutoscalerListComponent,
    KubernetesConfigHorizontalPodAutoscalerDetailComponent,
    KubernetesConfigHorizontalPodAutoscalerDetailMetricComponent
  ],
  exports: [
    KubernetesConfigHorizontalPodAutoscalerListComponent,
    KubernetesConfigHorizontalPodAutoscalerDetailComponent,
    KubernetesConfigHorizontalPodAutoscalerDetailMetricComponent
  ],
    imports: [
        CommonModule,
        KubernetesComponentsListModule,
        MatMenuModule,
        MatButtonModule,
        MatIconModule,
        RouterModule,
        LoaderModule,
        MatExpansionModule,
        FormContainerModule,
        FormMultipleContainerModule,
        DatePipe,
        MatChipsModule,
        KeyValuePipe,
        TableModule,
        MatDividerModule,
        KubernetesEventModule
    ],
  providers: [
    KubernetesConfigHorizontalPodAutoscalerService
  ]
})
export class KubernetesConfigHorizontalPodAutoscalerModule {

}
