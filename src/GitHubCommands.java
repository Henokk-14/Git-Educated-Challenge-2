package src;

import github.tools.client.GitHubApiClient;
import github.tools.responseObjects.*;
import git.tools.client.*;

public class GitHubCommands {
  //GitSubprocessClient gitSubprocessClient;

  //public GitHubCommands(){
//    String repoPath = "/Users/henokk_14/Downloads/CSC 109/Git-Educated-Challenge-2";
//    GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
    //String status = gitSubprocessClient.gitStatus();
   // GitAdd( gitSubprocessClient,"GitHubCommands.java");
//    String commitMessage = "added-Commit,Push-to-functions";
//    Commit(gitSubprocessClient, commitMessage);
//    Push(gitSubprocessClient, "main");
  //}
//  public static void main(String[] args){
//     GitHubCommands run =  new GitHubCommands();
//  }

  public String GitAdd(GitSubprocessClient gitSubprocessClient1,String filename) {
    try {
      String gitAddFile = gitSubprocessClient1.gitAddFile(filename);
      System.out.println(gitAddFile);
      if(gitAddFile.contains("fatal")){
        return  gitAddFile;
      } else
        return  "File: "+ filename+ " added";
    } catch (Exception e) {
      e.printStackTrace();
      return "Error file name entered incorrect file: "+ filename + " Doesn't exist in scope" ;
    }
  }
  public void Commit(GitSubprocessClient gitSubprocessClient, String CommitMsg){
    try{
      String commit = gitSubprocessClient.gitCommit(CommitMsg);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void Push(GitSubprocessClient gitSubprocessClient, String BranchName){
    try{
      String push = gitSubprocessClient.gitPush(BranchName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
