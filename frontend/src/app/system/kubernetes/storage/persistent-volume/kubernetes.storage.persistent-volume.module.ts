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
import {PipesReplicaSetReplicasModule} from "../../pipes/replica-set/replicas/pipes.replica-set.replicas.module";
import {TableModule} from "primeng/table";
import {MatDividerModule} from "@angular/material/divider";
import {PipesBytesModule} from "../../../../pipes/bytes/pipes.bytes.module";
import {KubernetesStoragePersistentVolumeService} from "./kubernetes.storage.persistent-volume.service";
import {
  KubernetesStoragePersistentVolumeDetailComponent
} from "./detail/kubernetes.storage.persistent-volume.detail.component";
import {
  KubernetesStoragePersistentVolumeListComponent
} from "./list/kubernetes.storage.persistent-volume.list.component";

@NgModule({
  declarations: [
    KubernetesStoragePersistentVolumeListComponent,
    KubernetesStoragePersistentVolumeDetailComponent
  ],
  exports: [
    KubernetesStoragePersistentVolumeListComponent,
    KubernetesStoragePersistentVolumeDetailComponent
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
    PipesReplicaSetReplicasModule,
    TableModule,
    MatDividerModule,
    PipesBytesModule
  ],
  providers: [
    KubernetesStoragePersistentVolumeService
  ]
})
export class KubernetesStoragePersistentVolumeModule {

}
